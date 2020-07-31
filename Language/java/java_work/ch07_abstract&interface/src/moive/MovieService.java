package moive;

import java.util.ArrayList;
import java.util.List;

import moive.vo.Movie;


/*
영화 저장,등록
영화 검색
삭제
수정(정보)
종료

class
Movie class : (String) title, (String) isbn, (String-enum) genre, nation, director, actor...
Actor class : name, age, 
*/
public class MovieService {
	
	List<Movie> movieList = new ArrayList<Movie>();
	
//	영화 저장,등록
	public void addMovie(Movie movie) {
		movieList.add(movie);
	}
//	영화 전체 목록
	public void movieList() {
		System.out.println("============영화목록============");
		for(Movie m : movieList) {
			System.out.println(m);
		}
	}
//	영화 검색
	public Movie searchMovie(String title) {
		System.out.println("============영화정보============");
		for(Movie m : movieList) {
			if(title.equals(m.getTitle())) {
				System.out.println(m);
				return m;
			}
		}
		System.out.println("해당 정보 없음");
		return null;
	}
//	삭제
	public void deleteMovie(Movie movie) {
		movieList.remove(movie);
	}
//	수정(정보)

//	종료

}
