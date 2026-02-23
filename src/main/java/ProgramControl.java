import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProgramControl {
        public File folder;
        public File[] listOfFiles;

        public ProgramControl() {
                folder =  new File(".");
                listOfFiles = folder.listFiles();
        }

        public void loadProgram(String filepath, String[] args) throws Exception {
                folder = new File(filepath);
                System.out.println(folder.getAbsolutePath());
                if (!folder.exists()) {
                        throw new Exception("Folder doesn't exist");
                }
                if (!folder.isDirectory()) {
                        throw new Exception("Folder is not a directory");
                }
                listOfFiles = folder.listFiles();

                if (listOfFiles == null) {
                        throw new Exception("Directory cannot be read");
                }

                if (listOfFiles.length == 0) {
                        throw new Exception("Directory is empty");
                }
                Ciphers userKey = new Ciphers(); // get original default key

                if (args.length == 0) // if no arguments are provided
                {

                        for (int i = 0; i < listOfFiles.length; i++) // iterate through each file in the folder
                        {
                                System.out.println(i + " " + listOfFiles[i]); // print file index and file name
                        }

                        System.exit(0); // exit
                }

                else if (args.length > 1) // if one or more arguments are provided
                {
                        try {
                                // if(args.length == 1) {
                                int index = Integer.parseInt(args[0]); // try to get the argument as an integer

                                if (args.length == 2) // if two arguments provided
                                {
                                        // userKey.loadCipher()
                                        // userKey = String.valueOf(args[1]); // consider separate user-entered cipher
                                } else
                                        userKey.loadCipher("ciphers/key.txt");

                                if (index < 0 || index >= listOfFiles.length) // if the index is out of bounds
                                {
                                        throw new Exception("Index out of bounds");
                                        // System.out.println("Invalid index"); // error
                                        // System.exit(0); // exit
                                } else { // if the index is within bounds of the number of files
                                        // try {
                                        BufferedReader br = new BufferedReader(new FileReader(listOfFiles[index])); // creates
                                                                                                                    // a
                                                                                                                    // buffered
                                                                                                                    // file
                                                                                                                    // reader
                                                                                                                    // for
                                                                                                                    // the
                                                                                                                    // file
                                                                                                                    // at
                                                                                                                    // that
                                                                                                                    // specific
                                                                                                                    // index
                                        String line;
                                        while ((line = br.readLine()) != null) {
                                                System.out.println(userKey.decipher(line)); // print contents of file
                                                                                            // DECIPHERED
                                        }
                                        br.close();
                                        // return "EXIT!";
                                        System.exit(0); // exit
                                        // }
                                        // catch (Exception e) {
                                        // e.printStackTrace();
                                        // }
                                }
                        } catch (NumberFormatException e) { // if a number is not entered
                                System.out.println(args[0] + " is not a valid number");
                        }
                }

                else { // if an illegal # of arguments are given
                        throw new Exception("Wrong number of arguments");
                }
        }

        public String getFileContent(String string) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getFileContent'");
        }

        public File[] getSortedFiles() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getSortedFiles'");
        }
}
