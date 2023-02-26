package Helper;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.testng.Assert;

public class helper {

	public void compareData(HashMap h1, HashMap h2) {
		System.out.println("Comparing data..");
		Assert.assertEquals((String) h1.get("Country"), (String) h2.get("Country"), "Country didn't match");
		SimpleDateFormat f2 = new SimpleDateFormat("dd MMMM yyyy");
		SimpleDateFormat f1 = new SimpleDateFormat("MMMM dd, yyyy");
		try {
			Date d1 = f1.parse((String) h1.get("Release"));
			Date d2 = f2.parse((String) h2.get("Release"));
			System.out.println(d1 + " " + d2);
			Assert.assertEquals(d1, d2, "Release date didn't match");
			if (d1.compareTo(d2) == 0) {
				System.out.println("Same Country->" + h1.get("Country"));
				System.out.println("Same Release date->" + d1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
