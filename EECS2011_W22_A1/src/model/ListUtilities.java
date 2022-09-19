package model;

import tests.Node;

public class ListUtilities {

	public Node<Integer> getMergedChain(Node<Integer> left, Node<Integer> right) {
		Node<Integer> result = null; 
		if(left == null && right == null) {
			result = null;
		}
		else { // left != null || right != null
			Node<Integer> currentL = left;
			Node<Integer> currentR = right;
			Node<Integer> current = null;
			while (currentL != null && currentR != null) {
				Node<Integer> toMerge;
				if(currentL.getElement() <= currentR.getElement()) {
					toMerge = new Node<>(currentL.getElement(), null);
					currentL = currentL.getNext();
				}
				else {
					toMerge = new Node<>(currentR.getElement(), null);
					currentR = currentR.getNext();
				} 

				if(result == null) { /* result is being initialized */ 
					result = toMerge;
					current = result;
				}
				else { /* result has been initialized -> use current to keep track */
					current.setNext(toMerge);
					current = current.getNext();
				}
			} 

			/* one of the input chains is null: the above while loop is skipped */
			if(current == null) {
				if(currentL == null) {
					result = new Node<>(currentR.getElement(), null);
					currentR = currentR.getNext();
				}
				else { // currentR == null
					result = new Node<>(currentL.getElement(), null);
					currentL = currentL.getNext();
				}
				current = result;
			}

			// Exiting the loop means: currentL == null || currentR == null 
			if(currentL == null) {
				while(currentR != null) {
					current.setNext(new Node<Integer>(currentR.getElement(), null));
					current = current.getNext();
					currentR = currentR.getNext();
				}
			}
			else if (currentR == null) {
				while(currentL != null) {
					current.setNext(new Node<Integer>(currentL.getElement(), null));
					current = current.getNext();
					currentL = currentL.getNext();
				}
			}
		}
		return result;
	}

	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int start, int diff, int n1, int n2) {
		Node<Integer> result = null;
		if(!(n1 == 0 && n2 == 0)) {
			int i = 0; // counter for arithmetic seq. of size `n1`  
			int j = 0; // counter for Fibonacci seq. of size `n2`
			Node<Integer> lastArithNode = null;
			Node<Integer> lastFibNode = null;
			Node<Integer> secondLastFibNode = null;
			Node<Integer> current = null;
			boolean turnOfArithSeq = true;
			while(i < n1 || j < n2) {
				int val = 0;
				boolean skip = false;
				if(turnOfArithSeq) {
					if(i < n1) {
						val = (lastArithNode == null) 
								? start 
										: lastArithNode.getElement() + diff;
						i ++;
						skip = false;
					}
					else {
						skip = true;
					}
				}
				else { // turn of Fib. Seq.
					if(j < n2) {
						val = (lastFibNode == null || secondLastFibNode == null) 
								? 1 
										: lastFibNode.getElement() + secondLastFibNode.getElement(); 
						j ++;
						skip = false;
					}
					else {
						skip = true;
					} 
				}

				if(!skip) {
					if(result == null) {
						result = new Node<>(val, null);
						current = result;
					}
					else {
						current.setNext(new Node<>(val, null));
						current = current.getNext();
					}

					if(turnOfArithSeq) {
						lastArithNode = current; 
					}
					else {
						secondLastFibNode = lastFibNode;
						lastFibNode = current; 
					}
				} 

				turnOfArithSeq = !turnOfArithSeq;
			}
		}
		return result;
	}

	public Node<String> getGroupedStrings(Node<String> start, int pivot1, int pivot2) {
		Node<String> startOfGroup1 = null;
		Node<String> startOfGroup2 = null;
		Node<String> startOfGroup3 = null;

		Node<String> currentOfGroup1 = null;
		Node<String> currentOfGroup2 = null;
		Node<String> currentOfGroup3 = null;

		Node<String> current = start;
		while(current != null) {
			String e = current.getElement();
			int size = e.length();  

			Node<String> newNode = new Node<>(e, null);
			if(size < pivot1) {
				if(startOfGroup1 == null) {
					startOfGroup1 = newNode;
					currentOfGroup1 = startOfGroup1;
				}
				else {
					currentOfGroup1.setNext(newNode);
					currentOfGroup1 = currentOfGroup1.getNext();
				}
			}
			else if(size < pivot2) {
				if(startOfGroup2 == null) {
					startOfGroup2 = newNode;
					currentOfGroup2 = startOfGroup2;
				}
				else {
					currentOfGroup2.setNext(newNode);
					currentOfGroup2 = currentOfGroup2.getNext();
				}
			}
			else {
				if(startOfGroup3 == null) {
					startOfGroup3 = newNode;
					currentOfGroup3 = startOfGroup3;
				}
				else {
					currentOfGroup3.setNext(newNode);
					currentOfGroup3 = currentOfGroup3.getNext();
				}
			}  
			current = current.getNext();
		}

		Node<String> result;
		if(startOfGroup1 == null) {
			if(startOfGroup2 == null) {
				if(startOfGroup3 == null) {
					// starter test (test_getGroupedStrings_02)
					result = null;
				}
				else {
					// extra test (test_getGroupedStrings_03)
					result = startOfGroup3;
				}
			}
			else {
				result = startOfGroup2;
				if(startOfGroup3 == null) {
					// extra test (test_getGroupedStrings_04)
					// do nothing
				}
				else {
					// extra test (test_getGroupedStrings_05)
					currentOfGroup2.setNext(startOfGroup3);
				}
			}
		}
		else {
			result = startOfGroup1;
			if(startOfGroup2 == null) {
				if(startOfGroup3 == null) {
					// extra test (test_getGroupedStrings_06)
					// do nothing
				}
				else {
					// extra test (test_getGroupedStrings_07)
					currentOfGroup1.setNext(startOfGroup3);
				}
			}
			else {
				currentOfGroup1.setNext(startOfGroup2);
				if(startOfGroup3 == null) {
					// extra test (test_getGroupedStrings_08)
					// do nothing
				}
				else {
					// starter test (test_getGroupedStrings_01)
					currentOfGroup2.setNext(startOfGroup3);
				}
			}
		}

		return result;
	}

	public Node<String> getAllPrefixes(Node<Integer> input, int m, int n) {
		Node<String> prefixes = null;

		Node<Integer> currentInput = input;
		Node<String> currentPrefix = null;

		int lengthOfPrefixes = 0;
		String prefixSoFar = "[";
		while(currentInput != null) {
			Integer i = currentInput.getElement();
			lengthOfPrefixes ++;
			
			String prefix;
			if(lengthOfPrefixes == 1) {
				prefix = prefixSoFar + i + "]";
				prefixSoFar += i;
			}
			else {
				prefix = prefixSoFar + ", " + i + "]";
				prefixSoFar += ", " + i;
			}
			
			if(m <= lengthOfPrefixes && lengthOfPrefixes <= n) {
				if(currentPrefix == null) {  
					currentPrefix = new Node<>(prefix, null);
					prefixes = currentPrefix;  
				}
				else {  
					currentPrefix.setNext(new Node<>(prefix, null));
					currentPrefix = currentPrefix.getNext();  
				} 
			}	 
			currentInput = currentInput.getNext();
		}

		return prefixes;
	}
}