# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1) The assertion “assertTrue(3 * .4 == 1.2)” fails because the representation of the float number in binary is not always exact. These representations can introduce small precision errors, meaning the result of 3 * 0.4 may be something like 1.2000000000000002 instead of exactly 1.2.

To correct this error, we should write “assertTrue(Math.abs(3 * 0.4 - 1.2) < 1e-9)” instead of  “assertTrue(3 * .4 == 1.2)”.

2) assertEqual checks if two objects are equal in value.
assertSame checks if two objects refer to the exact same memory location.

Scenario where assertEquals and assertSame produce the same result:

String str1 = "Hello";
String str2 = str1;

assertEquals(str1, str2);
assertSame(str1, str2); 

The two variables point to the same object so assertEquals and assertSame produce the same result. 

Scenario where assertEquals and assertSame produce different results:

String str1 = new String("Hello");
String str2 = new String("Hello");

assertEquals(str1, str2);
assertSame(str1, str2);


The two variables point to different objects but with the same content so assertEquals will pass, but assertSame will fail because they are not the same instance.

3) If the code enters a block that it should never reach (like after an early return or an exception), you can use fail() to signal that the test failed because it reached that "impossible" code. This is helpful for validating that a specific branch or statement should not be executed.

Exemple : 

public void testUnreachableCode() {
    if (condition) {
        return; // Expected behavior
    }
    fail("This code should not be reached because “condition” is true");
}

4) We think that introduction of assertThrows() in JUnit 5 improves precision and readability. It allows for testing exceptions in a more targeted manner.
