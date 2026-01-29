package io.github.baconpeeks.ci_guard.config;

/**
 * Configuration model loaded from {@code ci-guard.yml}.
 * <p>
 * Defines validation rules and limits applied during CI checks,
 * such as commit message format and length constraints.
 */
public class Config {

    /** Regular expression a commit message must satisfy */
    private String commitPattern;

    /** Maximum permitted length of a commit message */
    private int maxLength;

    /**
     * Returns the regex pattern used to validate commit messages.
     *
     * @return commit message validation pattern
     */
    public String getCommitPattern() {
        return commitPattern;
    }

    /**
     * Returns the maximum allowed commit message length.
     *
     * @return character limit
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the commit message validation pattern.
     *
     * @param commitPattern regular expression to enforce
     */
    public void setCommitPattern(String commitPattern) {
        this.commitPattern = commitPattern;
    }

    /**
     * Sets the maximum allowed commit message length.
     *
     * @param maxLength character limit
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
