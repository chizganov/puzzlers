@org.junit.jupiter.params.ParameterizedTest
@com.chizganov.puzzlers.util.TestSource(${CLASS_NAME}.class)
void ${NAME}(${CLASS_NAME} solution, java.nio.file.Path input, java.nio.file.Path output) throws java.io.IOException {
    try (java.io.BufferedReader in = java.nio.file.Files.newBufferedReader(input);
         java.io.BufferedReader out = java.nio.file.Files.newBufferedReader(output)) {
         ${BODY}
     }
}