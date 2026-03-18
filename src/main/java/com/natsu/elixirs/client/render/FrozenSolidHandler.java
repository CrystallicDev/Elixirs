package com.natsu.elixirs.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class FrozenSolidHandler {

    public static final ResourceLocation FROZEN_OVERLAY = new ResourceLocation(Elixirs.MODID, "textures/entity/frozen_solid.png");
    
	public static class FrozenSolidLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

	    public FrozenSolidLayer(LivingEntityRenderer<T, M> renderer) {
	    	super(renderer);
	    }
	    
	    @Override
	    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float linbSwingAmount,
	    		float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
	    	if (entity.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
	    		poseStack.pushPose();
	    		poseStack.scale(1.02f, 1.02f, 1.02f);		//Desperate attempt at avoiding Z fighting :(
	    		VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.entityTranslucentCull(FROZEN_OVERLAY));
	    		this.getParentModel().renderToBuffer(poseStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.7F);
	    	}
	    }
	}
	
	
}
