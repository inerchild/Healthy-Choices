package jdbc;
import java.util.Collections;
import java.util.Comparator;


public class ComparTour implements Comparator <Patient> {
	//use patient_id for comparator
	@Override
	public int compare (Patient q, Patient c) {
		if (q.patient_id.compareTo(c.patient_id) > 0) {
			return 1;
		}
		else if (q.patient_id.compareTo(c.patient_id) < 0) {
			return -1;
			
		}
		else return 0;
	}

	
	
	
}
