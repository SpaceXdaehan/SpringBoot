package com.itwill.spring2.stream;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;

// 스프링 컨텍스트(application-context.xml 또는 servlet-context.xml)를 사용하지 않는
// 단위 테스트에서는 @ExtendWith, @ContextConfiguration 애너테이션은 사용할 필요가 없다!
public class StreamTest {
    
    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);
        
        // numbers에서 홀수들만 필터링한 결과: stream의 filter() 메서드 사용.
        List<Integer> odds = numbers.stream()
                .filter((x) -> x % 2 == 1).toList();
        System.out.println(odds);
        
        // numbers의 원소들의 제곱: stream의 map() 메서드 사용.
        List<Integer> squares = numbers.stream()
                .map((x) -> x * x).toList();
        System.out.println(squares);
        
        // numbers의 원소들중 홀수들의 제곱: filter()메서드를 사용해 홀수를 찾고 map()메서드를 사용해 매핑
        List<Integer> oddsSquares = numbers.stream()
                .filter((x) -> x % 2 == 1).map((x) -> x * x).toList();
        System.out.println(oddsSquares);
        
        List<String> languages = Arrays.asList("Java", "SQL", "JS");
        System.out.println(languages);
        
        // languages가 가지고 있는 문자열들의 길이를 원소로 갖는 리스트를 만들
        List<Integer> lengths = languages.stream()
                .map((x) -> x.length()).toList();
                // .map(String::length)로 만들 수 있음, 아규먼트에서(x) 호출하는 값(메서드)이 하나거나 문장이 한줄 일 때
                // 람다의 기본 -> 아규먼트를 전달하면 return 값 나온다
        System.out.println(lengths);
        
        List<LocalDateTime> times = Arrays.asList(
                LocalDateTime.of(2023, 5, 23, 11, 30, 0),
                LocalDateTime.of(2023, 5, 24, 12, 40, 0),
                LocalDateTime.of(2023, 5, 25, 13, 50, 0)
        );
        System.out.println(times);
        
        // LocalDateTime 타입을 Timestamp 타입으로 변환.
        List<Timestamp> timestamps = times.stream()
                .map(Timestamp::valueOf)   // .map((x) -> Timestamp.valueOf(x))
                .toList();
        System.out.println(timestamps);
        
    }
    
    
    

}
