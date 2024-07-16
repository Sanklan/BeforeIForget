# Deep Learning 

## Basics
### Linear Classifiers 
classifier -->  f(x,w)=w1 ∗ x1 + w2
f(x,w)=w 1​ ∗x 1​ +w 2​ ∗x 2​ +w 3​
Training to determine w1, w2 etc. can you also be written as Matrix multiplication
f(x, W) = W * x + b where W N * N matrix and x & b are N dimensional vectors

Training is trying to find values in W matrix 
##### Loss function 
Loss (or cost) is a measure of how good or bad a classification of a data-point is. choice of the loss function depends on the problem and the form of the data.
example will be mean squared error distance. 
(f(xi, W) - ti) = distrance of ith point from the training data.. square it and sum and divide;; it's become a loss function.∑ (f(xi, W) - ti) ^ 2

```python
import torch
import torch.nn as nn

## classifier 10 input and 3 output
model = nn.Linear(10,3) 

## loss function MSE - mean square distance/error
loss = nn.MSELoss()
## dummy input x -
input_vector = torch.randn(10)
## class number 3, denoted as a vector with the class index to 1
target = torch.tensor([0,0,1])
## y in math
pred = model(input_vector)
## computing loss prediction and target
output = loss(pred, target)
print("Prediction: " ,pred)
print("Output: " , output)
### note: no optimization or training done here
```

steps 
- create classifier with random weight
- feed training example in the classfier and get output yi 
- compute loss yi - ti 
- adjust Weight 
- repeat
 
The loss computed can be considered as a function of input and W. Another thing is loss function cannot be negative if we are using MSE.  

consider loss calculate as function. We have to find global minimum. Minimize the loss function, which means we best fit the model. 

derivative of the loss function is slope.. which direction we are moving;; on min, both sides of slope are in different direction.

let's classifier function w1∗x+w2 and loss function will look something like this C=(f(xi,W)−yi)^2

So, derivative of Cost function w.r.t. to w1 or w2 or n.. called partial derivatives;; w1(t) = w1(t-1) - lambda*(derivate of loss function w.r.t.) and lamdba is how we are moving on the slope.. it's called learning rate. similarily we can do it for w2. λ(lamdba) is usually between milli to mirco, 10 to power 3 to 6.

based on this.. new steps 
1. Initialize the classifier with random weights 𝑊
2. Feed a training example 𝑥𝑖(vector) with corresponding target vector 𝑡𝑖in the classifier, and compute the output 𝑦𝑖
3. Compute the loss between the prediction 𝑦𝑖and target vector 𝑡𝑖
4. The mean squared error loss is commonly used 
5. Compute the gradients for the loss with respect to the weights/parameters.
6. Adjust the weights 𝑊 based on the rule w𝑖𝑡=𝑤𝑖^(𝑡−1)−𝑙(lambda)∗ ∂𝐶/∂𝑤i
7. Repeat for all training examples.

Using Pytorch
```python 
# classifier
model = nn.Linear(4,2)
# loss function 
criterion = torch.nn.MSELoss()

optimizer = torch.optim.SGD(model.parameters(), lr=0.1)

    for epoch in range(10):
        # Converting inputs and labels to Variable
        inputs = torch.Tensor([0.8,0.4,0.4,0.2])
        labels = torch.Tensor([1,0])

        # Clear gradient buffers because we don't want any gradient from previous epoch to carry forward
        optimizer.zero_grad()

        # get output from the model, given the inputs
        outputs = model(inputs)

        # get loss for the predicted output
        # Step 3
        loss = criterion(outputs, labels)
        print(loss)

        # get gradients w.r.t to parameters
        # calculate backward propogation.. 
        loss.backward()

        # update parameters.. step 6
        optimizer.step()

        print('epoch {}, loss {}'.format(epoch, loss.item()))


```