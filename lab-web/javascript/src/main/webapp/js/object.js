/**
 * object.js
 */

 document.addEventListener('DOMContentLoaded', function(){
    // JSON(JavaScript Object Notation): 자바스크립트에서 객체 표기법.
    // {property: value, ... }
    
    const person = {
        name: 'daehan',
        age: 30,
        phone: ['010-5090-2222', '02-0000-0000']
    };
    console.log(person);
    
    // 객체의 프로퍼티 접근(사용 2가지 방법):
    console.log(person.name);   // person 객체의 name 프로퍼티 값을 읽음.
    console.log(person.age);    // person 객체의 age 프로퍼티 값을 읽음.
    console.log(person.phone);  // person 객체의 phone 프로퍼티 값을 읽음.
    
    console.log(person['age']); // person 객체의 age프로퍼티 값을 읽음.    
    console.log(person['phone']); // person 객체의 phone프로퍼티 값을 읽음.
    console.log(person.phone[0]); // person 객체의 phone프로퍼티 인덱스 0번째 값을 읽음.
    console.log(person['phone'][1]); // person 객체의 phone프로퍼티 인덱스 1번째 값을 읽음.
    
    person.name = 'meta';   // person 객체의 name 프로퍼티 값을 변경. (객체에 원래 있던 값을 추가하는 게 아니라 재설정 해줌)
    console.log(person);
    
    // 자바스크립트 객채는 프로퍼티를 추가할 수 있음
    person.company = '아이티윌';    // 위에 person객체에서 프로퍼티 값을 설정하지 않아도 밑에서 프로퍼티를 추가할 수 있음.
    console.log(person);
    
    // 객체에서(Object) for-in 구문:
    // 객체에서 배열은 키(프로퍼티이름들)를 반복함(iteration).
    for(let key in person) {
        console.log(key); // name, age, phone
        console.log(key,':',person[key]);   // (key, ':', person[name]);
    }
    
    // 메서드를 갖는 객체:
    // 1회성. 점수가 바뀔 때마다 바꿔줘야됨(비효율적)
    const score = {
        korean: 100,
        english: 90,
        math: 80,
        sum: function() {
            return this.korean + this.english + this.math;
        },
        mean: function() {
            return this.sum() / 3;
        }
    };
    console.log(score);
    console.log(score.sum());   // sum 메서드 호출
    console.log(score.mean());   // mean 메서드 호출
    console.log('=============================================================================================');
    
    
    // 생성자 함수:
    function Score(korean, english, math) {
        // 자바로 치면 필드에 해당하는 부분
        this.korean = korean;
        this.english = english;
        this.math = math;
        
        // 메서드
        this.sum = function() {
            return this.korean + this.english + this.math;
        };
        this.mean = function() {
            return this.sum() / 3;
        };
    }
    
    // 생성자 함수를 호출하는 방법.
    const score1 = new Score(10, 20, 30);
    console.log(score1);
    console.log(score1.sum());  // sum() 메서드 호출
    console.log(score1.mean()); // mean() 메서드 호출
    
    const score2 = new Score(90, 95, 88);
    console.log(score2);
    console.log(score2.sum());  // sum() 메서드 호출
    console.log(score2.mean()); // mean() 메서드 호출
    
 });