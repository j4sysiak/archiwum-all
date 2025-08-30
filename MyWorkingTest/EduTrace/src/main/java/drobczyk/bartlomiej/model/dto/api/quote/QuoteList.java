package drobczyk.bartlomiej.model.dto.api.quote;

import java.util.List;

public class QuoteList {
    private Integer count;
    private Integer totalCount;
    private Integer lastItemIndex;
    private List<Result> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLastItemIndex() {
        return lastItemIndex;
    }

    public void setLastItemIndex(Integer lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        private List<String> tags;
        private String _id;
        private String content;
        private String author;
        private String authorSlug;
        private Integer length;

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorSlug() {
            return authorSlug;
        }

        public void setAuthorSlug(String authorSlug) {
            this.authorSlug = authorSlug;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }
    }
}
