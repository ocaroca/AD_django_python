from django.shortcuts import render
from rest_framework import viewsets
from .models import Imagen
from .serializers import ImagenSerializer
# Create your views here.

class ImagenViewSet(viewsets.ModelViewSet):
    serializer_class = ImagenSerializer
    queryset = Imagen.objects.all()