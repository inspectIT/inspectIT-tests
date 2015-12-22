package test.info.novatec.inspectit.coreclassinstrumentation;

import org.testng.annotations.Test;

/**
 * Test if the Java-Coreclasses are instrumented. Playing with java.lang.String
 * 
 * @author Alfred Kraus
 */
public class CoreClassTest {

	@Test
	public void coreClassTest() {
		String string = "abcdefghijklmnopqrstuvwxyz";
		String string2 = "";
		String[] stringarr;

		System.out.println("Starting CoreClass - Tests ...");
		System.out.println();

		boolean emptyString = string.isEmpty();
		if (!emptyString) {
			System.out.println("Not empty");
		}
		string.concat(string2);
		emptyString = string2.isEmpty();
		if (emptyString) {
			System.out.println("Empty");
		}
		System.out.println("String:");
		System.out.println(string);
		System.out.println("Doubled String:");
		string = string.concat(string);
		System.out.println(string);
		stringarr = string.split("z");
		System.out.println("Splitted at \"z\": " + stringarr[0] + " - "
				+ stringarr[1]);
		System.out.println("CharAt(0):");
		System.out.println(string.charAt(0));
		System.out.println("Contains(abc):");
		System.out.println(string.contains("abc"));
		System.out.println("IndexOf(b):");
		System.out.println(string.indexOf("b"));
		System.out.println("Substring 5-10:");
		System.out.println(string.substring(5, 10));
		stringarr[0] = stringarr[0].replaceFirst("a", "A");
		System.out.println("Length");
		System.out.println(string.length());
		System.out.println("Compares:");
		System.out.println(string.compareToIgnoreCase(stringarr[0]));
		System.out.println(string.compareTo(stringarr[0]));
		System.out.println("LastIndexOf(a):");
		System.out.println(string.lastIndexOf("a"));

		System.out.println();
		System.out.println("Finished CoreClass - Tests");
	}
}
