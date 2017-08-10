/**
 * Defines a queue.
 */
function Queue() {
  this.first = null;
  this.size = 0;
}

/**
 * Creates a node.
 * 
 * @param {*} data 
 */
function Node(data) {
  this.data = data;
  this.next = null;
}

/**
 * Adds a node in the queue.
 */
Queue.prototype.enqueue = function(data) {
  var newNode = new Node(data);
  if (!this.first) {
    this.first = newNode;
  } else {
    var pointerNode = this.first;
    while (pointerNode.next) {
      pointerNode = pointerNode.next;
    }
    pointerNode.next = newNode;
  }
  this.size++;
  
  return newNode;
};

/**
 * Removes a node from the queue.
 */
Queue.prototype.dequeue = function() {
  if (!this.first) {
    printData("Underflow condition.");
  } else {
    var tempNode = this.first;
    this.first = tempNode.next;
    this.size--;
    
    return tempNode;
  }
};

/**
 * Displays the queue.
 */
Queue.prototype.displayQueue = function() {
  if (!this.first) {
    printData("Queue is empty.");
  } else {
    var tempNode = this.first;
    while(tempNode) {
      printData(tempNode.data + "-->");
      tempNode = tempNode.next;
    }
  }
};

/**
 * Displays the queue and dequeues every element from the queue.
 */
Queue.prototype.displayAndEmptyQueue = function() {
  if (!this.first) {
    printData("Queue is empty.");
  } else {
    while (this.first) {
      printData(this.first.data + "-->");
      this.first = this.first.next;
      this.size--;
    }
  }
};

/**
 * Prints data to the console.
 * 
 * @param {*} data 
 */
function printData(data) {
  console.log(data);
}