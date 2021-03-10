package posjavamavenhibernate;

import org.junit.Test;

import junit.framework.TestCase;

public class TesteBanco extends TestCase {
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
