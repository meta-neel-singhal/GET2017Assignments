/**
 * Defines a stack.
 */
function Stack() {
  this.top = null;
  this.size = 0;
}

/**
 * Creates a node.
 * 
 * @param {*} data 
 */
function Node(data) {
  this.data = data;
  this.previousNode = null;
}

/**
 * Adds a node in the stack.
 */
Stack.prototype.push = function(data) {
  var newNode = new Node(data);
  newNode.previousNode = this.top;
  this.top = newNode;
  this.size++;

  return this.top;
};

/**
 * Removes a node from the stack.
 */
Stack.prototype.pop = function() {
  if (1 > this.size) {
    printData("Underflow condition.");
  } else {
    var tempNode = this.top;
    this.top = this.top.previousNode;
    this.size--;

    return tempNode;
  }
};

/**
 * Displays the stack.
 */
Stack.prototype.displayStack = function() {
  var pointerNode = this.top;
  if (!pointerNode) {
    printData("Stack is empty.");
  } else {
    var tempNode = {};
    while(pointerNode) {
      tempNode = pointerNode;
      pointerNode = pointerNode.previousNode;
      printData(tempNode.data + "<--");
    }
  }
};

/**
 * Displays the stack and pops every element from the stack.
 */
Stack.prototype.displayAndEmptyStack = function() {
  if (!this.top) {
    printData("Stack is empty.");
  } else {
    var tempNode = {};
    while(this.top) {
      tempNode = this.top;
      this.top = this.top.previousNode;
      this.size--;
      printData(tempNode.data + "<--");
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