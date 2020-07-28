package class03_method;

public class ParameterEx {

	public static void main(String[] args) {
		Parameter parameter = new Parameter();

		int result = parameter.sum1(3, 9);
		System.out.println("result: " + result);

		int[] values = { 11, 22, 33, 44, 55, 66, 77 };

		result = parameter.sum1(values);
		System.out.println("result: " + result);

		System.out.println(parameter.sum2(1, 2, 3, 4, 5));

	}

}
