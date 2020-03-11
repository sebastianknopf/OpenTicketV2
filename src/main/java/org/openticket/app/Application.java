package org.openticket.app;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.openticket.security.SecurityKeyGenerator;
import org.apache.commons.cli.*;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * Application class for running openticket.jar as console application.
 */
public class Application {

    private static boolean isQuiet = false;

    /**
     * Main method entry point.
     *
     * @param args Command line args
     */
    public static void main(String[] args) {
        Options defaultOptions = new Options();
        defaultOptions.addOption("q", "quiet", false, "suppress any output on console");

        Options keygenOptions = new Options();
        keygenOptions.addOption("s", "size", true, "desired key size in bits");
        keygenOptions.addOption("private", true, "path to the private key file");
        keygenOptions.addOption("public", true, "path to the public key certificate file");

        try {
            CommandLineParser parser = new ArgumentOptionsParser();
            CommandLine cmd = parser.parse(defaultOptions, args);

            Application.isQuiet = cmd.hasOption("q");

            // dispatch first argument as action to the according method
            if (args.length > 0) {
                if (args[0].equals("keygen")) {
                    DefaultParser keygenParser = new DefaultParser();
                    cmd = keygenParser.parse(keygenOptions, args);

                    // if no options set, display help
                    if (cmd.getOptions().length < 1) {
                        HelpFormatter helpFormatter = new HelpFormatter();
                        helpFormatter.printHelp("keygen", keygenOptions);
                    } else {
                        Application.keyGen(cmd);
                    }
                }
            } else {
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp("OpenTicket", defaultOptions);
            }
        } catch (ParseException e) {
            Application.writeMessage(e.getMessage());
        }
    }

    /**
     * Generates a security rsa keypair.
     *
     * @param cmd Command line args
     */
    private static void keyGen(CommandLine cmd) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            String privateFilename = cmd.getOptionValue("private");
            String publicFilename = cmd.getOptionValue("public");
            int keySize = Integer.parseInt(cmd.getOptionValue("s", "1024"));

            SecurityKeyGenerator skg = new SecurityKeyGenerator();
            skg.generateKeyPair(privateFilename, publicFilename, keySize);
        } catch (Exception e) {
            Application.writeMessage("unable to generate key pair");
        }
    }

    /**
     * Displays a desired message text to the console output if application isn't running
     * in silent mode.
     *
     * @param message The message to print
     */
    private static void writeMessage(String message) {
        if (!Application.isQuiet) {
            System.out.println(message);
        }
    }

    /**
     * Command line parser accepting also arguments between the desired known options.
     */
    private static class ArgumentOptionsParser extends DefaultParser {
        @Override
        public CommandLine parse(Options options, String[] arguments) throws ParseException {
            List<String> knownOptions = new ArrayList<String>();
            for (String arg : arguments) {
                if (options.hasOption(arg)) {
                    knownOptions.add(arg);
                }
            }

            return super.parse(options, knownOptions.toArray(new String[0]));
        }
    }
}
