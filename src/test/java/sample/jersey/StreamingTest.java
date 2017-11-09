package sample.jersey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class StreamingTest {

	@Test
	public void enTest(){
		List<Integer> myList = getRandoArrayOfInt(100000000,100);
		LocalDateTime now = LocalDateTime.now();
		String format ="ss";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		System.out.println( now.format(formatter));
		myList
				.parallelStream()
				//.filter(s -> s.startsWith("1"))
				//.map(String::toUpperCase)
				//.flatMapToInt(n-> IntStream.of(Integer.parseInt(n)))
				.sorted().toArray();
				//.forEach( n -> System.out.print(String.format("%d|",n)));
		now = LocalDateTime.now();
		System.out.println( now.format(formatter));
		assertThat(true).isNotNull();
	}

	private List<Integer> getRandoArrayOfInt(int max,int range){
		List<Integer> liste = new ArrayList<>();
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= max; ++idx){
			int randomInt = randomGenerator.nextInt(range);
			liste.add(new Integer(randomInt));
		}
		return liste;
	}

}
