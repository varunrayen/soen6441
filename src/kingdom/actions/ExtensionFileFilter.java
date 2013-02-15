/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.actions;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author andriy
 */
class ExtensionFileFilter extends FileFilter {

    String extensions[];
    String description;

    public ExtensionFileFilter(String description, String[] extensions) {
        this.extensions = extensions;
        this.description = description;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensions.length; i < n; i++) {
                String extension = extensions[i];
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
