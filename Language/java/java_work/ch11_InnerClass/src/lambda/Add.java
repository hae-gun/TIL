package lambda;

// Functioncal Interface 는 추매서드 1개만 갖을수 있다.
@FunctionalInterface
public interface Add {

	public int add(int x, int y);
}
