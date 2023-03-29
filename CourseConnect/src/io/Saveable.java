package io;

import java.io.File;

// Interface for saving and loading objects to and from disk
public interface Saveable {
    
    public void Save(File saveFile);
    public void Load(File saveFile);

}
