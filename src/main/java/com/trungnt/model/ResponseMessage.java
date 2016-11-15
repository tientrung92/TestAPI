package com.trungnt.model;

public class ResponseMessage {
  /**
   * Default constructor.
   */
  public ResponseMessage() {
    super();
  }

  /**
   * Response message constructor.
   *
   * @param message
   *          Message
   */
  public ResponseMessage(String message) {
    this.message = message;
  }

  String message;

  /**
   * Get message.
   *
   * @return Message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Set message.
   *
   * @param message
   *          Message
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
