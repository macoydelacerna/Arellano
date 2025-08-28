/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spotifyplaylistsim;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author BED
 */
public class SpotifyPlaylistSim {

   private static ArrayList<String> playlist = new ArrayList<>();
    private static Stack<ArrayList<String>> undoStack = new Stack<>();
    private static Stack<ArrayList<String>> redoStack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            printMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSong(scanner);
                    break;
                case 2:
                    removeLastSong();
                    break;
                case 3:
                    undo();
                    break;
                case 4:
                    redo();
                    break;
                case 5:
                    viewPlaylist();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Spotify Playlist Simulator ---");
        System.out.println("1. Add Song");
        System.out.println("2. Remove Last Song");
        System.out.println("3. Undo");
        System.out.println("4. Redo");
        System.out.println("5. View Playlist");
        System.out.println("6. Exit");
    }

    private static void addSong(Scanner scanner) {
        System.out.print("Enter song name to add: ");
        String song = scanner.nextLine();
        saveStateToUndo();
        playlist.add(song);
        redoStack.clear();
        System.out.println("\"" + song + "\" added to playlist.");
    }

    private static void removeLastSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is already empty.");
            return;
        }
        saveStateToUndo();
        String removedSong = playlist.remove(playlist.size() - 1);
        redoStack.clear();
        System.out.println("\"" + removedSong + "\" removed from playlist.");
    }

    private static void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        saveStateToRedo();
        playlist = undoStack.pop();
        System.out.println("Undo successful.");
    }

    private static void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        saveStateToUndo();
        playlist = redoStack.pop();
        System.out.println("Redo successful.");
    }

    private static void viewPlaylist() {
        System.out.println("\n--- Current Playlist ---");
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    private static void saveStateToUndo() {
        undoStack.push(new ArrayList<>(playlist));
    }

    private static void saveStateToRedo() {
        redoStack.push(new ArrayList<>(playlist));
    }
}