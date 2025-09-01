package io;

import java.util.Scanner;

public final class Input {
    private Input () { }

    public static String read(String message){
        return new Scanner(System.in).nextLine();
    }
}
