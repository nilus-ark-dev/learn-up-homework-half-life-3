import java.io.*;

public class Main {

    private static final String CHECK_POINT = "saves.txt";

    public static void main(String[] args) throws IOException {
        final Progress playerProgress = new Progress("Return to Ravenholm", "Gordon_but_not_Ramsay", 2);
        saveProgress(playerProgress);

        final Progress progress = loadProgress();
        System.out.printf(
                "You saved your progress at level %s with profile %s \nNumber of your check point %d\n",
                progress.getLevel(),
                progress.getPlayerNick(),
                progress.getSaveNumber());
    }

    private static boolean saveProgress(Progress progress) {
        try (FileOutputStream fos = new FileOutputStream(CHECK_POINT);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(progress);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static Progress loadProgress() {
        try (
                FileInputStream fis = new FileInputStream(CHECK_POINT);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            final Object obj = ois.readObject();
            Progress result = (Progress) obj;
            return result;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
