package com.danieldev.danieldev.Core.Usecases;

    public class CreateIdentifierCaseImpl implements CreateIdentifierCase {

        @Override
        public String execute() {
            int length = 6;
            String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvwxyz";

            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int index = (int) (alphaNumericString.length() * Math.random());
                sb.append(alphaNumericString.charAt(index));
            }

            return sb.toString();
        }
    }

