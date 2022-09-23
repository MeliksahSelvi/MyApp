package dto;

public class ContentDto {

    private int id;
    private String head;
    private String content;

    public ContentDto(int id, String head, String content) {
        this.id = id;
        this.head = head;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}