package stack_queue;

import java.util.Stack;

public class CoinStack {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();

		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));

		Coin coin = coinBox.pop();
		System.out.println("마지막에 넣은 동전: "+coin.getValue());
		coin = coinBox.pop();
		System.out.println("현재 가장 위에 놓인 동전: "+coin.getValue());
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));

		Coin peekCoin = coinBox.peek();
		
		System.out.println("peekCoin: "+peekCoin.getValue());
		
		System.out.println("현재 가장 위에 놓인 동전: "+coinBox.peek().getValue());
		
		while(!coinBox.empty()) {
			coin = coinBox.pop();
			System.out.println("뺀동전: "+coin.getValue());
		}
		
		
		
	}
}
