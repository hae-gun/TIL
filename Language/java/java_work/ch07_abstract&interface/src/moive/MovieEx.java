package moive;

import java.util.Scanner;

import moive.m_enum.Genre;
import moive.vo.Movie;

public class MovieEx {
	public static void main(String[] args) {
		Movie m = new Movie("a","111-1111", Genre.ACTION);
		
		MovieService ms = new MovieService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("========= 영화 관리 프로그램 =========");
			System.out.println("1:등록 2:목록 3:");
			int check = Integer.parseInt(sc.nextLine());
			switch (check) {
			case 1:
				
				break;

			default:
				break;
			}
		}
		
//		ms.addMovie(m);
//		ms.movieList();
//		
//		ms.deleteMovie(m);
//		ms.movieList();
		
	}
}
