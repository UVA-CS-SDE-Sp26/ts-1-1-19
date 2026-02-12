public class CommandLine {
    public void run(String[] args) {
        ProgramControl controller = new ProgramControl();

        if (args.length == 0) {
            controller.listFiles();
            return;
        }

        if (args.length == 1) {
            String fileNumber = args[0];

            if (!isTwoDigitNumber(fileNumber)) {
                printUsage();
                return;
            }

            controller.displayFile(fileNumber, null);
            return;
        }

        if (args.length == 2) {
            String fileNumber = args[0];
            String key = args[1];

            if (!isTwoDigitNumber(fileNumber)) {
                printUsage();
                return;
            }

            controller.displayFile(fileNumber, key);
            return;
        }
        printUsage();
    }
    private boolean isTwoDigitNumber(String s) {
        return s != null && s.length() == 2 && Character.isDigit(s.charAt(0)) && Character.isDigit(s.charAt(1));
    }

    private void printUsage() {
        System.out.println("Usage:");
        System.out.println("java topsecret");
        System.out.println("java topsecret 01");
        System.out.println("java topsecret 01 key");
    }
}
