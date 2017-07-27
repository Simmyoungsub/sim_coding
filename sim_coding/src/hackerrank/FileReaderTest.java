package hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTest extends TestCase {
	private FileReader _input;
	public FileReaderTest (String name) {
		super(name);
	}
	
	protected void setUp() {
		try {
			_input = new FileReader("경로");
		}catch(FileNotFoundException e) {
			throw new RuntimeException("테스트 파일을 열수없음");
		}
	}
	
	protected void tearDown() {
		try {
			_input.close();
		}catch(IOException e) {
			throw new RuntimeException("테스트 파일 닫는중 에러 발생");
		}
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new FileReaderTest("testRead"));
		return suite;
	}
	
	public void testRead() throws IOException{
		char ch = '&';
		for(int i=0;i<4;i++) {
			ch = (char)_input.read();
		}	
		
		assertEquals('d',ch);
	}
	
	public static void main(String[] args) {
		//junit.textui.TestRunner.run(FileReaderTest.suite());
		K k = new K();
		System.out.println(k);
		tt(k);
		
		System.out.println(k);
	}
	
	public static void tt(K k) {
		K k_a = k;
		
		k_a.setName("park");
	}
	
}

class K{
	private String name;

	K(){
		this.name = "hong";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "K [name=" + name + "]";
	}
	
	
}
