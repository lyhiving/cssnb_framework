import java.util.Collection;
import java.util.List;

import com.cssnb.commons.domain.Page;


public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = List.class.isAssignableFrom(Collection.class);
		
		System.out.println(res);
		res = List.class.isAssignableFrom(Iterable.class);
		System.out.println(res);
	}

}
