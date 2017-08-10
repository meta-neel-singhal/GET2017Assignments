/**
 * Helps to remove the redundant data from the input data and further reduces
 * the obtained data if any redundancy is found.
 */
function removeRedundant(data) {
  var previousPosition = 0;
  var currentPosition = 0;
  var currentLength = 0;
  printData("Your input data is: " + data);
  // Runs to check redundancy in the full string.
  while (currentPosition < data.length) {
    if (data.charAt(previousPosition) === data.charAt(currentPosition)) {
      currentLength++;
      currentPosition++;
    } else if (currentLength > 1) {
      data = data.slice(0, previousPosition) + data.slice(currentPosition);
      printData("Reduced to: " + data);
      previousPosition = (previousPosition - 1) > 0 ? (previousPosition - 1) : 0;
      currentLength = 0;
      currentPosition = previousPosition;
    } else {
      previousPosition = currentPosition;
      currentLength = 0;
    }
  }
  // If the redundancy is in the last part of the string.
  if (currentLength > 1) {
    data = data.slice(0, previousPosition) + data.slice(currentPosition);
    printData("Reduced to: " + data);
  }
}

/**
 * Helps to print the data on the console.
 */
function printData(data) {
  console.log(data);
}