package hello;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Collection;
import java.text.DecimalFormat;


/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */
@SpringComponent
@UIScope
public class HealthyChoiceEditor extends VerticalLayout {

	private final HealthyChoiceRepository repository;

	/**
	 * The currently edited customer
	 */
	private HealthyChoice currentChoice;

	//Fields to edit properties in HealthyChoice entity 
	
	TextField ID = new TextField("ID");
	//TextField Description = new TextField("description");

	/*private Component cancel;
	{*/
	
	//this.filter = new TextField(id, description);
	

	//Action buttons 
	TextField id = new TextField("ID");
	
	TextField description = new TextField("DESCRIPTION");
	
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<HealthyChoice> binder = new Binder<>(HealthyChoice.class);
	
	
	//?need this to get the field text to show in the browser
	//root.addComponent(text);
	//setContent(root);
	
	

	@Autowired
	public HealthyChoiceEditor(HealthyChoiceRepository repository) {
		this.repository = repository;

		//Component save;
		//Component delete;
		//addComponents(save, cancel, delete);
		addComponents(id,description);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		
		save.addClickListener(e -> repository.save(currentChoice));
		delete.addClickListener(e -> repository.delete(currentChoice));
		cancel.addClickListener(e -> editHealthyChoice(currentChoice));
		setVisible(false);
	}
		
		//description.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		

		// wire action buttons to save, delete and reset
		

	public interface ChangeHandler {

		void onChange();
	}

	public final void editHealthyChoice(HealthyChoice c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			currentChoice= repository.findOne(c.getId());
						
		}
		else {
			
			currentChoice = c;
		}
		
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(currentChoice);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in description field automatically
		id.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
