package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@RunWith(Parameterized.class)
public class AddTwoNumbers2Test {

    private AddTwoNumbers2Data testData;

    public AddTwoNumbers2Test(AddTwoNumbers2Data testData) {
        this.testData = testData;
    }

    @Test
    public void addTwoNumberTests() {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();

        AddTwoNumbers2.ListNode actual = addTwoNumbers2.addTwoNumbers(testData.left, testData.right);
        List<Integer> actualIntegers = convertListNodeToList(actual);

        Assert.assertEquals(testData.expected, actualIntegers);
    }

    @AllArgsConstructor
    @Getter
    private static class AddTwoNumbers2Data {
        AddTwoNumbers2.ListNode left;
        AddTwoNumbers2.ListNode right;
        List<Integer> expected;
    }

    @Parameters
    public static List<AddTwoNumbers2Data> testData() {

        return Arrays.asList(
                new AddTwoNumbers2Data(convertListToListNode(asList(3, 4, 2)), convertListToListNode(asList(4, 6, 5)), asList(7, 0, 8)),
                new AddTwoNumbers2Data(convertListToListNode(singletonList(0)), convertListToListNode(singletonList(0)), singletonList(0)),
                new AddTwoNumbers2Data(convertListToListNode(singletonList(5)), convertListToListNode(singletonList(5)), asList(0, 1)),
                new AddTwoNumbers2Data(convertListToListNode(singletonList(9)),
                        convertListToListNode(asList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)), asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1))
        );
    }


    static AddTwoNumbers2.ListNode convertListToListNode(List<Integer> integers) {
        AddTwoNumbers2.ListNode answer = new AddTwoNumbers2.ListNode(0);
        AddTwoNumbers2.ListNode node = null;

        for (Integer integer : integers) {
            if (node != null) {
                node.next = new AddTwoNumbers2.ListNode(integer);
                node = node.next;
            }

            if (answer.val == 0 && answer.next == null) {
                node = new AddTwoNumbers2.ListNode(integer);
                answer = node;
            }
        }
        return answer;
    }

    static List<Integer> convertListNodeToList(AddTwoNumbers2.ListNode node) {

        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list;
    }
}