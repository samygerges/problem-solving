import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		List<Number[]> queryResult = new ArrayList<>();
		queryResult.add(new Number[] { 1, 1, 10 });
		queryResult.add(new Number[] { 2, 0, 20 });
		queryResult.add(new Number[] { 3, 1, 30 });
		queryResult.add(new Number[] { 4, 0, 40 });
		//sort queryResult in reverse order to have only published item count in map
		queryResult.sort(new Comparator<Number[]>()
		{
			@Override
			public int compare(Number[] o1, Number[] o2)
			{
				return (int) o2[1] - (int) o1[1];
			}
		});
		System.out.println(queryResult);
	}
}
