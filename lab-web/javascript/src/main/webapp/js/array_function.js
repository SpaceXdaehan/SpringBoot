/**
 * array_function.js
 */

 document.addEventListener('DOMContentLoaded', function() {
     const numbers = [1, 2, 3, 4, 5, 6, 7];
     
     // 배열 concat() 메서드: 배열에 새로운 원소를 끝에 추가. 원소가 추가된 새로운 배열을 리턴.
     // 배열 push() 메서드: 기존 배열에 끝에 원소를 추가. 리턴값은 없음.
     const arr = []; // 빈 배열을 선언.
     console.log(arr);
     
     arr.push(100);
     console.log(arr);
     
     arr.push(200);
     console.log(arr);
         
     let arr2 = []; // 빈 배열을 선언.
     console.log(arr2);
     
     arr2 = arr2.concat(1);
     console.log(arr2);
        
     arr2 = arr2.concat(2);
     console.log(arr2);
     
     // 1. 배열 numbers의 원소들 중에서 홀수들만 원소로 갖는 배열을 만들고 출력.

     let odds = [];
     for (let x of numbers) {   // 배열의 원소를 순서대로 반복
         if (x % 2) {   // 2로 나눈 나머지가 있으면(홀수이면)
             odds = odds.concat(x); // 홀수를 추가한 새로운 배열을 생성.
         }
     }
     console.log(odds);
     
     odds= numbers.filter((x) => x % 2); // 함수를 (x)로 넘겨줌     
     console.log(odds);
     
     // 2. 배열 numbers의 원소들을 제곱한 숫자들을 원소로 갖는 배열을 만들고 출력.
     let squares = [];
     for (let i of numbers) {
         squares = squares.concat(i ** 2); // i ** i **: 거듭제곱 연산자
      }
     console.log(squares);
     
     squares = numbers.map((x) => x ** 2); // map은 배열의 리턴값 자체를 넣어줌
     console.log(squares);
         
     // 3. 배열 numbers의 원소들 중에서 홀수의 제곱을 원소로 갖는 배열을 만들고 출력.
     let odd = [];
     for (let y of numbers) {
         if (y % 2) {
             odd = odd.concat(y ** 2);
         }
     }
     console.log(odd);
     
     odd = numbers.filter((y) => y % 2).map((y) => y ** 2); // numbers의 숫자들의 filter메서드를 사용해 y로 넘겨주고 y % 2 / y를 mapping해서 **2
     console.log(odd);
     
     
 });