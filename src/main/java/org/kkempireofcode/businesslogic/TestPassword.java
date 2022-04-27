package org.kkempireofcode.businesslogic;

public class TestPassword {
        public  static void main(String[] args) throws Exception {
            String password="000";
            String encriptedpassword=EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(password));
            System.out.println("Encripted Password is: "+encriptedpassword);
        }
}
