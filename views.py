from django.shortcuts import render
from rest_framework import viewsets
from .models import Imagen
from .serializers import ImagenSerializer
from rest_framework.filters import OrderingFilter
from django_filters.rest_framework import DjangoFilterBackend
# Create your views here.

class ImagenViewSet(viewsets.ModelViewSet):
    serializer_class = ImagenSerializer
    queryset = Imagen.objects.all()
    filter_backends = (DjangoFilterBackend, OrderingFilter)
    filter_fields = ('titulo', 'autor', 'precio', 'reservado')
    