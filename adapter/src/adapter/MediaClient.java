package adapter;

import java.util.Objects;

// Target Interface
interface MediaPlayer {
  void play(String fileName);
}

// Adaptee 1 (MP4 Player with different method)
class Mp4Player {
  public void playMp4(String filename) {
    System.out.println("Playing MP4 file: " + filename);
  }
}

// Adaptee 2 (VLC Player with different method)
class VlcPlayer {
  public void playVlc(String filename) {
    System.out.println("Playing VLC file: " + filename);
  }
}

// TODO: Create Mp4Adapter class here
class Mp4Adapter implements MediaPlayer {
  private final Mp4Player player;

  public Mp4Adapter(Mp4Player player) {
    this.player = Objects.requireNonNull(player);
  }

  @Override
  public void play(String fileName) {
    if (!fileName.endsWith(".mp4")) {
      throw new IllegalArgumentException("Invalid file type: " + fileName);
    }
    player.playMp4(fileName);
  }
}

// TODO: Create VlcAdapter class here
class VlcAdapter implements MediaPlayer {
  private final VlcPlayer player;

  public VlcAdapter(VlcPlayer player) {
    this.player = Objects.requireNonNull(player);
  }

  @Override
  public void play(String fileName) {
    if (!fileName.endsWith(".vlc")) {
      throw new IllegalArgumentException("Invalid file type: " + fileName);
    }
    player.playVlc(fileName);
  }
}

// Client Code
public class MediaClient {
  public static void main(String[] args) {
    Mp4Player mp4Player = new Mp4Player();
    VlcPlayer vlcPlayer = new VlcPlayer();

    // TODO: Create adapters
    MediaPlayer mp4Adapter = new Mp4Adapter(mp4Player);
    MediaPlayer vlcAdapter = new VlcAdapter(vlcPlayer);

    playMedia(mp4Adapter, "video.mp4");
    playMedia(vlcAdapter, "movie.vlc");
  }

  private static void playMedia(MediaPlayer player, String file) {
    player.play(file);
  }
}
