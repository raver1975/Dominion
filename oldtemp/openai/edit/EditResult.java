package com.theokanning.openai.edit;

import lombok.Data;

import java.util.List;

/**
 * A list of edits generated by GPT-3
 *
 * https://beta.openai.com/docs/api-reference/edits/create
 */
@Data
public class EditResult {

    /**
     * The type of object returned, should be "edit"
     */
    String object;

    /**
     * The creation time in epoch milliseconds.
     */
    long created;

    /**
     * A list of generated edits.
     */
    List<EditChoice> choices;
}
