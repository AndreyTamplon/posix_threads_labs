import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FileProcessor
{
    public List<String> readFile(String fileName) throws FileNotFoundException
    {
        List<String> text = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                FileProcessor.class.getResourceAsStream(
                                        fileName)))))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                text.add(line);
            }
        }
        catch (IOException | NullPointerException exception)
        {
            throw new FileNotFoundException("The program failed to open the file");
        }
        return text;
    }
}
