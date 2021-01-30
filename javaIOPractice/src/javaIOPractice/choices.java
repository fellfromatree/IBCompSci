package javaIOPractice;
import java.util.Scanner;
public class choices {
 
  public static void main(String[] args) {
    // 
    System.out.println("This PC");
    Scanner choose = new Scanner(System.in);
    int folder = 0;
    boolean s = true;
    while (s = true) {
    if (folder == 0)
      System.out.println("1.OS (C:)\n2.New Volume (D:)");
      int chose = choose.nextInt();
      folder = folder +1;
      
    if (folder == 1) {
      if (chose == 1) {
        System.out.println("1.Program Files\n2.Program Files(x86)\n3.<--");
        chose = choose.nextInt();
        folder = folder +1;}}
    
      if (folder == 2) {
        if (chose == 1) {
          System.out.println("1.WinRAR\n2.NVIDIA Corporation\n3.<--");
          chose = choose.nextInt();
          folder = folder +1;}
        if (folder ==3) {
          if (chose == 1) {
            System.out.println("40 days free trial");}
          if (chose == 2) {
            System.out.println("NVIDIA GeForce");}
          if (chose == 3) {
            folder = 1;}}
        }
      if (folder == 2) {
        if (chose == 2) {
          System.out.println("1.Google\n2.Intel\n3.<--");
          chose = choose.nextInt();
          folder = folder +1;}
        if (folder ==3) {
          if (chose == 1) {
            System.out.println("Chrome");}
          if (chose == 2) {
            System.out.println("grafiks");}
          if (chose == 3) {
            folder = 1;}}
        if (chose == 3) {
        folder = 0;} }
 
      if (folder == 1) {
      if (chose == 2) {
        System.out.println("1.Games\n2.Steam\n3.<--");
        chose = choose.nextInt();
        folder = folder +1;}
      }
      if (folder == 2) {
        if (chose == 1) {
          System.out.println("1.Persona 5\n2.Yoshi's island\n3.<--");
          chose = choose.nextInt();
          folder = folder +1;}
        if (folder ==3) {
          if (chose == 1) {
            System.out.println("persona 5[CODEX] cracked");}
          if (chose == 2) {
            System.out.println("yoshiDies.exe");}
          if (chose == 3) {
            folder = 1;}}
        }
      if (folder == 2) {
        if (chose == 2) {
          System.out.println("1.steamapps\n2.steamAPI\n3.<--");
          chose = choose.nextInt();
          folder = folder +1;}
        if (folder ==3) {
          if (chose == 1) {
            System.out.println("common");}
          if (chose == 2) {
            System.out.println("steamworksAPI");}
        if (chose == 3) {
          folder = 1;}}
}}}}
