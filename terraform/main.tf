terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "4.6.0"
    }
  }
}

provider "docker" {}

data "docker_image" "cen4802" {
  name = "cen4802-logging:latest"
}

resource "docker_network" "cen4802_network" {
  name = "cen4802-terraform-network"
}

resource "docker_container" "cen4802_app" {
  name  = "cen4802-terraform-container"
  image = data.docker_image.cen4802.id

  memory = 384

  ports {
    internal = 8080
    external = 8084
  }

  networks_advanced {
    name = docker_network.cen4802_network.name
  }

  restart = "unless-stopped"
}