'use strict'; // For strict mode.

/**
 * Create a node.
 * 
 * @param {*} data 
 */
function Node(data) {
  this.data = data;
  this.next = null;
}

/**
 * Helps to create linked list.
 */
function LinkedList() {
  this.head = null;
  this.length = 0;
}

/**
 * Adds a new node to the linked list.
 */
LinkedList.prototype.addNode = function (data) {
  var newNode = new Node(data);
  var pointerNode = this.head;
  // If first node.
  if (!pointerNode) {
    this.head = newNode;
  } else {
    while (pointerNode.next) {
      pointerNode = pointerNode.next;
    }
    pointerNode.next = newNode;
  }
  this.length++;

  return newNode;
};

/**
 * Gets the node at a particular position.
 */
LinkedList.prototype.searchByPosition = function (num) {
  var count = 1;
  var pointerNode = this.head;
  if (isNotValid(this.length, num)) {
    printData('Doesn\'t Exist!');
  } else {
    while (count < num) {
      pointerNode = pointerNode.next;
      count++;
    }

    return pointerNode;
  }
};

/**
 * Removes the nodes from a particular position.
 */
LinkedList.prototype.deleteByPosition = function (num) {
  var count = 1;
  var pointerNode = this.head;
  var prevNode = null;
  // Error check.
  if (isNotValid(this.length, num)) {
    printData('Doesn\'t Exist!');
  } else {
    while (count < num) {
      prevNode = pointerNode;
      pointerNode = pointerNode.next;
      count++;
    }
    // If the node is first node.
    if (1 === num) {
      this.head = pointerNode.next;
      this.length--;
    }
    // All other cases.
    else {
      prevNode.next = pointerNode.next;
      pointerNode = null;
      this.length--;
    }

    return this.head;
  }
};

/**
 * Displays the linked list.
 */
LinkedList.prototype.displayList = function () {
  var pointerNode = this.head;
  if (!pointerNode) {
    printData('Linked list is empty.');
  } else {
    while (pointerNode) {
      printData(pointerNode.data + '-->');
      pointerNode = pointerNode.next;
    }
  }
};

/**
 * Search a data in the linked list.
 */
LinkedList.prototype.searchByValue = function (num) {
  var pointerNode = this.head;
  var found = false;
  var count = 1;
  if (!pointerNode) {
    printData('Linked list is empty.');
    found = true;
  } else {
    while (pointerNode) {
      if (num === pointerNode.data) {
        printData(num + ' is found at position ' + count);
        found = true;
      }
      count++;
      pointerNode = pointerNode.next;
    }
  }
  if (!found) {
    printData(num + ' is not found in the list.');
  }
  return found;
}

/**
 * Delete a data from the linked list.
 */
LinkedList.prototype.deleteByValue = function (num) {
  var pointerNode = this.head;
  var previousNode = null;
  var deleted = false;
  if (!pointerNode) {
    printData('Linked list is empty.');
    deleted = true;
  } else if (pointerNode.data === num) {
    this.head = pointerNode.next;
    printData(num + " is deleted.");
    deleted = true;
  }
  else {
    while (pointerNode) {
      if (pointerNode.data === num) {
        previousNode.next = pointerNode.next;
        printData(num + " is deleted.");
        deleted = true;
        this.length--;
        break;
      }
      previousNode = pointerNode;
      pointerNode = pointerNode.next;
    }
  }
  if (!deleted) {
    printData(num + ' is not found in the list.');
  }
}

/**
 * Prints data to the console.
 * 
 * @param {*} data 
 */
function printData(data) {
  console.log(data);
}

/**
 * Checks if the entered number is not a valid node position.
 *  
 * @param {int} size 
 * @param {int} num 
 */
function isNotValid(size, num) {
  var result = false;
  if (size < num || 1 > num) {
    result = true;
  }

  return result;
}