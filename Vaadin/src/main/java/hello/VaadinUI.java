package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {

	private final HealthyChoiceRepository repo;

	private final HealthyChoiceEditor editor;

	final Grid<HealthyChoice> grid;

	//final TextField filter;
	final TextField filter;

	private final Button addNewBtn;

	@Autowired
	public VaadinUI(HealthyChoiceRepository repo, HealthyChoiceEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(HealthyChoice.class);
		this.filter = new TextField();
		//this.filterdescription = new TextField();
		this.addNewBtn = new Button("New customer", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "description", "product_picture", "meal_picture");

		filter.setPlaceholder("Filter by id");
		filter.setPlaceholder("Filter by description");
		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listChoices_tblDesription(e.getValue()));
		
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		

		// Connect selected Customer to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			//editor.editDescription(e.getValue());
		});

		// Instantiate and edit new Customer the new button is clicked
		addNewBtn.addClickListener(e -> editor.editHealthyChoice(new HealthyChoice()));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			
			listChoices_id(filter.getValue());
			
			listChoices_id(filter.getValue());
		});

		// Initialize listing
		listChoices_tblId(null);
		listChoices_tblDesription(null);
		
	}

	// tag::listCustomers[]
	void listChoices_tblId(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(repo.findAll());
		}
		
		else {
			grid.setItems(repo.findByIdStartsWithIgnoreCase(filterText));
		}
	}
			
		
		void listChoices_tblDesription(String filterText) {
			if (StringUtils.isEmpty(filterText)) {
				grid.setItems(repo.findAll());
			}
			
			else {
				grid.setItems(repo.findByIdStartsWithIgnoreCase(filterText));
			}
		
		}
		
		void listChoices_id(String filterText) {
			if (StringUtils.isEmpty(filterText)) {
				
				grid.setItems(repo.findAll());
			}
			else {
				grid.setItems(repo.findByDescriptionStartsWithIgnoreCase(filterText));
			}	
		}		
		// end::listProducts[]

	}
			
	