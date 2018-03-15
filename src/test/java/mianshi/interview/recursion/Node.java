package mianshi.interview.recursion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private final int value;
    private Node next;

    public Node(int value){
        this.value = value;
    }
}
