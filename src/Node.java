import java.io.File;
import java.util.ArrayList;
public class Node
{

    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;



    long sizeLimit;

    public Node(File folder, long sizeLimit)
    {
        this.folder = folder;
        children = new ArrayList<>();
        this.sizeLimit = sizeLimit;
    }

    public Node(File folder){
        this(folder, 0);
    }

    public long getSizeLimit() {
        return sizeLimit;
    }
    public File getFolder() {
        return folder;
    }

    public void addChild(Node node){
        node.setLevel(level + 1);
        children.add(node);
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toString(){
//        String size = SizeCalculator.getHumanReadableSize(getSize());
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
            builder.append(folder.getName() + " - " + size + "\n");
            for (Node child : children) {
                if(child.getSize() < sizeLimit){
                    continue;
                }
                builder.append("  ".repeat(level + 1) + child.toString());
            }

        return builder.toString();
    }
    private void setLevel(int level){
        this.level = level;
    }
}
