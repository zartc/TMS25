package zc.study.struts1;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TestObject1 {
	@Test
	public void testMethod1() {
		String s = "Pascal";
		assertThat(s).startsWith("Pas").endsWith("cal")
				.isEqualToIgnoringCase("pascal");
	}
}
