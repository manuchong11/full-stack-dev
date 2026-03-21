Deployment Strategy (Task C3):
 To deploy the Landon Hotel multithreaded Spring application, I would use Amazon Web Services (AWS) as the cloud service provider. Specifically, I would use Amazon Elastic Container Service (ECS)
with AWS Fargate.

The Deployment Process:
1.  Container Registry: I would push the built Docker image (d387-hotel) to the Amazon Elastic Container Registry (ECR), which is a private storage area for Docker images.
2.  Cluster Setup: I would create an ECS cluster that uses AWS Fargate. Fargate is a "serverless" container engine that automatically handles the underlying servers, allowing the application to
      scale up or down based on traffic.
3.  Task Definition: I would define an ECS "Task" that specifies the Docker image to use and the required resources (CPU and RAM).
4.  Networking: I would configure an Application Load Balancer (ALB) to distribute incoming web traffic across multiple instances of the running container for high availability.
5.  Security: Finally, I would use AWS Security Groups to ensure that only port 8080 (the application's web port) is open to the public internet. 
