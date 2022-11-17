import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;


class listfiltercheck implements StringChecker {
  String str;
  public listfiltercheck() { str = " "; }
  public listfiltercheck(String s) { str = s; }
  public boolean checkString(String s)
    {
        return s.contains(str);
    }
}

public class TestListExamples{
    @Test
    public void filtercheck() { 
        listfiltercheck sc = new listfiltercheck("app");
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("whole");
        list1.add("app");

        List<String> result = new ArrayList<>();
        result.add("apple");
        result.add("app");
        assertEquals(result, ListExamples.filter(list1,sc));
    }

    @Test
    public void filtercheck1() { 
        listfiltercheck sc = new listfiltercheck();
        List<String> list1 = new ArrayList<>();
        list1.add("g");
        list1.add("1");
        list1.add("g");
        list1.add("s");

        List<String> result = new ArrayList<>();
        list1.add("g");
        list1.add("1");
        list1.add("g");
        list1.add("s");

      
        assertEquals(result, ListExamples.filter(list1,sc));
    }

    @Test 
	public void testFilter1() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("g");

        List<String> list2 = new ArrayList<>();
        list2.add("c");
        list2.add("f");
        list2.add("w");
        List<String> result = new ArrayList<>();
        result.add("a");
        result.add("b");
        result.add("c");
        result.add("f");
        result.add("g");
        result.add("w");
        assertEquals(result, ListExamples.merge(list1, list2));
	}

    @Test 
	public void testFilter2() {
    List<String> list1 = new ArrayList<>();
    list1.add("c");
    List<String> list2 = new ArrayList<>();
    list2.add("a");
    List<String> result = new ArrayList<>();
    result.add("a");
    result.add("c");
    assertEquals(result, ListExamples.merge(list1, list2));
	}
    @Test(timeout = 100)
    public void testTimeout() {
	while(true) {}
    }

}
